package com.beans.roaststars;


import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.beans.roaststars.model.service.CafeService;
import com.beans.roaststars.model.service.ReviewService;
import com.beans.roaststars.model.vo.CafeOperatingTimeVO;
import com.beans.roaststars.model.vo.CafeVO;
import com.beans.roaststars.model.vo.PropertyVO;
import com.beans.roaststars.model.vo.UserVO;


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
		*/
		// test 1. 카페넘버로 카페 정보 불러오기
		//System.out.println(cafeService.findCafeByCafeNo("1"));
		/*
		// test 2. 카페 넘버로 리뷰 리스트 불러오기
		for(ReviewListVO vo:reviewService.findReviewListByCafeNo("1")) {
			System.out.println(vo);
		}*/
		/*
		// test 3. 카페 넘버로 리뷰 총 개수 불러오기
		System.out.println(reviewService.findReviewTotalCountByCafeNo("1"));
		
		
		// test 4. 카페 넘버로 리뷰 리스트 불러오기- 페이징 테스트
		ReviewListVO listVO = reviewService.findReviewListByCafeNo("1");
		for(ReviewVO vo: listVO.getReviewList()) {
			System.out.println(vo);

		}
		
		}*/
		
		// Test 카페등록하기
		/*
		 * UserVO uvo= new UserVO(); uvo.setId("java11"); CafeVO vo = new CafeVO();
		 * vo.setUserVO(uvo); vo.setCafeName("sdfasdfsasdf");
		 * vo.setCafeLoc("dvd124qwd"); vo.setCafeInfo("asdasdaqw124dda");
		 * vo.setCafeTel("012410-6565-95664864"); vo.setCafeNo("asdafag"); //
		 * cafeService.registerCafe(vo);
		 * 
		 * System.out.println(vo.getCafeNo());
		 * 
		 * System.out.println(cafeService.findcafeByNoNotJoin(vo.getCafeNo())); vo =
		 * cafeService.findcafeByNoNotJoin(vo.getCafeNo()); System.out.println(vo);
		 * CafeOperatingTimeVO ovo = new CafeOperatingTimeVO();
		 * ovo.setWeekendTime("1241");ovo.setHolidayTime("2142");ovo.setWeekdayTime(
		 * "1261"); ovo.setCafeVO(vo);
		 * 
		 * // cafeService.registerCafeOperatingTime(ovo);
		 * System.out.println(cafeService.findCafeByCafeNo(vo.getCafeNo()));
		 */
		UserVO uvo = new UserVO();
		uvo.setId("java11");
		List<CafeVO> list = cafeService.getCafeList(uvo.getId());
		for(int i = 0; i<list.size(); i++)
			System.out.println(list.get(i));
		CafeVO cafeVO = new CafeVO();
		cafeVO.setUserVO(uvo);
		cafeVO =  cafeService.findcafeByNoNotJoin("48");
		CafeOperatingTimeVO cafeOperVO = new CafeOperatingTimeVO();
		cafeOperVO.setCafeVO(cafeVO);
		cafeOperVO.setWeekendTime("1241");cafeOperVO.setHolidayTime("2142");cafeOperVO.setWeekdayTime("1261");
		System.out.println(cafeOperVO);
		
		System.out.println(cafeService.findCafeByCafeNo(cafeOperVO.getCafeVO().getCafeNo()));
		cafeOperVO.setWeekendTime("1");cafeOperVO.setHolidayTime("2");cafeOperVO.setWeekdayTime("3");
		cafeVO.setCafeName("스타벅스");
		cafeService.updateCafe(cafeVO, cafeOperVO);
		System.out.println(cafeService.findCafeByCafeNo(cafeOperVO.getCafeVO().getCafeNo()));
		/*
		 * CafeVO vo = new CafeVO(); vo.set CafeOperatingTimeVO ovo = new
		 * CafeOperatingTimeVO();
		 */
		  
		// test 5. 카페리스트 특성에 따라 정렬하기
		  /*
		String[] arrOption= {"taste", null , "service"};
		List<PropertyVO> list=cafeService.cafeListSortByProperty(arrOption, "부천");
		for(PropertyVO vo: list)
			System.out.println(vo);
		List<CafeOperatingTimeVO> list = cafeService.findListByLoc("부천");
		for(CafeOperatingTimeVO vo:list) {
			System.out.println(vo);
		}
		System.out.println(cafeService.findCafeByCafeNo("1"));	
		   */	
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