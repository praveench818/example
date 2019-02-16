package com.praveen.Hospital.web.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.praveen.Hospital.support.jpa.CustomJpaRepository;
import com.praveen.Hospital.web.entity.UserInfo;

public interface UserInfoRepository  extends CustomJpaRepository<UserInfo, Long> {
	
	

	@Query(value=" From UserInfo u where  u.username =:userName)")
	public UserInfo findByUsername(@Param("userName") String userName);
	
	
	
	//public UserInfo findByUsername(String userName);
}
