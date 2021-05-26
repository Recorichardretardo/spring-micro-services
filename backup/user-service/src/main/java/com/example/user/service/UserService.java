package com.example.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.user.entity.User;
import com.example.user.repository.UserRepository;

import VO.Department;
import VO.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		log.info("saveUser method in userRepository");
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUserWithDepartmnent(Long userId) {
		log.info("getUserWithDepartmnent method in userRepository");
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = userRepository.findByUserId(userId);

		Department department = restTemplate.getForObject("http://localhost:9001/departments/" + user.getDepartmentId(),
				Department.class);
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
	}
}
