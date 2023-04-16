package kr.co.kmarket1.controller.admin.product;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.kmarket1.dao.AdminProductRegisterDao;
import kr.co.kmarket1.dao.CateDao;
import kr.co.kmarket1.vo.ProductVO;
import kr.co.kmarket1.vo.Cate1VO;



@WebServlet("/admin/product/register.do")
public class AdminProductRegisterController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 등록 성공 여부를 위해 success 수신 - 구홍모 12/10
		String success = req.getParameter("success");
		req.setAttribute("success", success);
		
		// cate1 리스트 불러오기 - 구홍모 12/09
		List<Cate1VO> cate1s = CateDao.getInstance().selectCates_1();
		req.setAttribute("cate1s", cate1s);
		
		// view forward
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/product/register.jsp");
		dispatcher.forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// multipart 전송 데이터 수신 - 구홍모 12/10
		ServletContext application = req.getServletContext();
		String savePath = application.getRealPath("/thumb"); // 썸네일(이미지파일) 저장 경로
		int maxSize = 1024 * 1024 * 10; // 최대 파일 업로드 허용치 10mb
		MultipartRequest mr = new MultipartRequest(req, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		// 수신된 썸네일 파일들의 경로를 캐치하는 작업 - 구홍모 12/10
		Enumeration e = mr.getFileNames();
		ArrayList<String> saveFiles = new ArrayList<>(); // 저장된 파일이름이 들어갈 리스트 
		ArrayList<String> newFiles = new ArrayList<>();  // 중복을 막기 위해 바뀐 파일이름이 들어갈 리스트
		while(e.hasMoreElements()) { 
			String n = (String) e.nextElement();
			saveFiles.add(mr.getFilesystemName(n)); // 각 썸네일 파일의 이름을 리스트에 넣기
		}
		// 파일명 수정 - 구홍모 12/10
		for(int i=0;i<4;i++) {
		String Fname = saveFiles.get(i);
		int idx = Fname.lastIndexOf(".");
		String ext = Fname.substring(idx);//ext는 확장자 ex)txt,jpg,gif
		
		String random = UUID.randomUUID().toString();
		String newName = random + ext;
		
		
		File oriFile = new File(savePath+"/"+Fname);
		File newFile = new File(savePath+"/"+newName);
		
		newFiles.add(newName); // 새 이름의 썸네일 파일의 이름을 리스트에 넣기
		
		oriFile.renameTo(newFile); // 파일명 수정
		}
		// 데이터 수신 (req에서 MultipartRequest로 변환) - 구홍모 12/10
		String prodCate1 = mr.getParameter("category1"); // 1차 분류
		String prodCate2 = mr.getParameter("category2"); // 2차 분류
		String prodName  = mr.getParameter("prodName"); // 상품명
		String descript  = mr.getParameter("descript"); // 기본설명
		String company	 = mr.getParameter("company");  // 제조사
		String seller	 = mr.getParameter("seller");   // 판매자 - 필수라 추가함 : 구홍모
		String price	 = mr.getParameter("price");	// 판매가격
		String discount  = mr.getParameter("discount"); // 할인율
		String point	 = mr.getParameter("point");	// 포인트
		String stock	 = mr.getParameter("stock");	// 재고수량
		String delivery	 = mr.getParameter("delivery");	// 배송비
		String thumb1	= "/Java1_Kmarket1/thumb/"+newFiles.get(0);	// 상품 썸네일1(의 저장경로)
		String thumb2	= "/Java1_Kmarket1/thumb/"+newFiles.get(1);	// 상품 썸네일2(의 저장경로)
		String thumb3	= "/Java1_Kmarket1/thumb/"+newFiles.get(2);	// 상품 썸네일3(의 저장경로)
		String detail	= "/Java1_Kmarket1/thumb/"+newFiles.get(3);	// 상세 상품정보(의 저장경로)
		String status	= mr.getParameter("status");	// 상품상태
		String duty		= mr.getParameter("duty");		// 부가세 면세여부
		String receipt	= mr.getParameter("receipt");	// 영수증 발행
		String bizType	= mr.getParameter("bizType");	// 사업자 구분
		String origin	= mr.getParameter("origin");	// 원산지
		String ip		= req.getRemoteAddr(); // ip는 판매자ip
		
		// VO 데이터 생성 - 구홍모 12/10
		ProductVO vo = new ProductVO();
		vo.setProdCate1(prodCate1);
		vo.setProdCate2(prodCate2);
		vo.setProdName(prodName);
		vo.setDescript(descript);
		vo.setCompany(company);
		vo.setSeller(seller);
		vo.setPrice(price);
		vo.setDiscount(discount);
		vo.setPoint(point);
		vo.setStock(stock);
		vo.setDelivery(delivery);
		vo.setThumb1(thumb1);
		vo.setThumb2(thumb2);
		vo.setThumb3(thumb3);
		vo.setDetail(detail);
		vo.setStatus(status);
		vo.setDuty(duty);
		vo.setReceipt(receipt);
		vo.setBizType(bizType);
		vo.setOrigin(origin);
		vo.setIp(ip);
		
		
		// 데이터베이스 처리
		int result = AdminProductRegisterDao.getInstance().insertProduct(vo);	// 12.15 중현 ProductDao > AdminProductRegisterDao 수정
			
		// 리다이렉트 - 구홍모 12/10
		if(result > 0) {
			//성공 시
			// resp.sendRedirect("/Java1_Kmarket1/admin/product/list.do"); 상품등록 기능 완전히 구현되면 이 경로로
			resp.sendRedirect("/Java1_Kmarket1/admin/product/register.do?success=101"); // 아직 기능검사 중이라 이 경로로
		}else {
			//실패 시
			resp.sendRedirect("/Java1_Kmarket1/admin/product/register.do?success=201");
		}
	}
}
