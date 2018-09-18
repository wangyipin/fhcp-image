package com.njsecnet.fhcp.image.controller;

import com.njsecnet.fhcp.image.config.ApplicationProperties;
import com.njsecnet.fhcp.image.service.impl.ProjectServiceImpl;
import com.njsecnet.fhcp.image.util.FileUtils;
import com.njsecnet.fhcp.image.util.SpringContextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("/HarborProjectController.do")

public class HarborProjectController {

	private Logger logger = LoggerFactory.getLogger(HarborProjectController.class);

	private ProjectServiceImpl projectServiceImpl;
	@Autowired
	private HarborProjectController(ProjectServiceImpl projectServiceImpl) {
		this.projectServiceImpl = projectServiceImpl;
	}

	/**
	 * 查询项目名和仓库
	 *
	 * @param q
	 *            项目名/仓库名
	 * @return ResponseEntity
	 */
	@GetMapping(value = "/searchProjectAndRepositories")
	public ResponseEntity<Object> searchProjectAndRepositories(String q, HttpServletRequest request,
			HttpServletResponse response) {

		Map responseData = projectServiceImpl.search(q);

		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}

	/**
	 * 获取项目列表
	 *
	 * @param name
	 *            项目名
	 * @param isPublic
	 *            是否私有
	 * @param owner
	 *            所有者
	 * @param page
	 *            第几页
	 * @param pageSize
	 *            每页显示条数
	 * @return ResponseEntity
	 */
	@GetMapping(value = "/projectList")
	public ResponseEntity<Object> projectList(String name, boolean isPublic, String owner, String page, String pageSize,
			HttpServletRequest request, HttpServletResponse response) {

		Map responseData = projectServiceImpl.projectList(name, isPublic, owner, page, pageSize);

		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}

	/**
	 * 检查项目名称是否存在
	 *
	 * @param projectName
	 *            检测的项目名
	 * @return ResponseEntity
	 */
	@GetMapping(value = "/checkProjectNameIsExists")
	public ResponseEntity<Object> checkProjectNameIsExists(ModelMap model, String projectName,
			HttpServletRequest request, HttpServletResponse response) {

		String responseData = projectServiceImpl.checkProjectNameIsExists(projectName);

		model.addAttribute("code", responseData);

		if ("200".equals(responseData)) {
			model.addAttribute("msg", "项目名已存在");
		} else if ("401".equals(responseData)) {
			model.addAttribute("msg", "请先登陆");
		} else if ("404".equals(responseData)) {
			model.addAttribute("msg", "项目名称不存在");
		} else if ("500".equals(responseData)) {
			model.addAttribute("msg", "意外的内部错误");
		}
		return new ResponseEntity<>(model, HttpStatus.OK);
	}

	/**
	 * io数据流测试
	 *
	 * @return ResponseEntity
	 */
	@GetMapping(value = "ioFunction")
	public ResponseEntity<Object> ioFunction() {

		String msg = FileUtils.copyFile("d://常州照片.7z");
		logger.info(msg);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	/**
	 * test get properties
	 *
	 * @return ResponseEntity
	 */
	@GetMapping(value = "testContextUtil")
	public ResponseEntity<Object> testContextUtil() {

		String username = SpringContextUtils.getBean(ApplicationProperties.class).getUserName();

		String password = SpringContextUtils.getBean(ApplicationProperties.class).getPassword();

		logger.info(username + "--------------------" + password);

		return new ResponseEntity<>("", HttpStatus.OK);
	}

}
