package com.moviemang.datastore.domain.member;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberId;

//	@Column(name = "member_name")
	@NotBlank
	private String memberName; // 닉네임

//	@Column(name = "member_email")
	@Email(message = "올바른 이메일이 아닙니다.")
	private String memberEmail; // 이메일

//	@Column(name = "member_password")
	@Length(min = 8, max = 20)
	@NotBlank
	private String memberPassword; // 비밀번호

//	@Column(name = "member_type")
	private String memberType;

	// MariaDB에 기본값으로 넣어야 함
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private String regDate; // 회원 등록일
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private String modDate; // 회원 수정일

	@Builder
	public Member(Long memberId, String memberEmail, String memberName, String memberPassword, String memberType,
			String regDate, String modDate) {
		this.memberId = memberId;
		this.memberEmail = memberEmail;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberType = memberType;
		this.regDate = regDate;
		this.modDate = modDate;
	}
}