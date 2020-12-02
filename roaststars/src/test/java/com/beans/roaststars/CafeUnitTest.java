package com.beans.roaststars;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.beans.roaststars.model.service.CafeService;
import com.beans.roaststars.model.service.ReviewService;
import com.beans.roaststars.model.vo.ReviewListVO;
import com.beans.roaststars.model.vo.ReviewVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring-model.xml","file:src/main/webapp/WEB-INF/spring-security.xml"})
public class CafeUnitTest {
	@Resource
	CafeService cafeService;
	
	@Resource
	ReviewService reviewService;

	
	@Test
	public void cafeUnitTest() {
		/*System.out.println(cafeService.findListByLoc("부천"));
		
		// test 1. 카페넘버로 카페 정보 불러오기
		System.out.println(cafeService.findCafeByCafeNo("1"));
		
		// test 2. 카페 넘버로 리뷰 리스트 불러오기
		for(ReviewVO vo:reviewService.findReviewListByCafeNo("1")) {
			System.out.println(vo);
		}
		
		// test 3. 카페 넘버로 리뷰 총 개수 불러오기
		System.out.println(reviewService.findReviewTotalCountByCafeNo("1"));
		
		
		// test 4. 카페 넘버로 리뷰 리스트 불러오기- 페이징 테스트
		ReviewListVO listVO = reviewService.findReviewListByCafeNo("1");
		for(ReviewVO vo: listVO.getReviewList()) {
			System.out.println(vo);
		}*/
		
		// test 5. 카페 정보 상세보기 페이지
		
	}
}
		//        사용법 예시             //
		/*
		@Resource
		ItemDAO itemDAO;
		@Test
		public void itemCountTest() {
			//System.out.println(itemDAO.getItemCount());
			//								1. 기대값		2.실제값
			//Assert.assertEquals(8, itemDAO.getItemCount());
			//Assert.assertNotNull(itemDAO.findItemByNo(2));
			//System.out.println(itemDAO.findItemByNo(1));
			// 아이템 등록 테스트
			// 아이템 번호는 시퀀스로 자동 생성
			ItemVO ivo=new ItemVO();
			ivo.setName("아몬드");
			ivo.setMaker("롯데");
			ivo.setPrice(1000);
			System.out.println("동록전: "+ ivo);
			itemDAO.registerItem(ivo);
			System.out.println("등록완료: "+ivo);
		}
		*/