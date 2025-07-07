package com.green.firstserver;

import com.green.firstserver.model.MemoGetOneRes;
import com.green.firstserver.model.MemoGetRes;
import com.green.firstserver.model.MemoPostReq;
import com.green.firstserver.model.MemoPutReq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //빈(Bean)등록, 스프링 컨테이너 객체 생성을 대리로 맡긴다., 요청/응답 담당자
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

//    public MemoController(MemoService memoService) {
//        this.memoService = memoService;
//    }

    //DI 받는 방법 3가지
    //1. 필드 주입
    //2. setter 주입 (메소드 주입)
    //3. 생성자 주입

    @PostMapping("/memo")
    public String postMemo(@RequestBody MemoPostReq req) { //@RequestBody는 JSON 데이터를 받을꺼야.
        System.out.println("postMemo: " + req);
        int result = memoService.insMemo(req);
        return result == 1 ? "성공" : "실패";
    }

    @GetMapping("/ddd")
    public String getDdd() {
        return "ddd";
    }
    @GetMapping("/sss")
    public String getSss() {
        return "sss";
    }
    @GetMapping("/ggg")
    public String getGgg() {
        return "ggg";
    }

    @GetMapping("/memo")
    public List<MemoGetRes> getMemo() {
        return memoService.selMemoList();
    }

    @GetMapping("/memo/{id}")
    public MemoGetOneRes getMemo(@PathVariable int id) {
        System.out.println("getMemo: " + id);
        return memoService.selMemo(id);
    }

    @PutMapping("/memo")
    public String putMemo(@RequestBody MemoPutReq req) {
        System.out.println("postMemo: " + req);
        int result = memoService.updMemo(req);
        return result == 1 ? "성공" : "실패";
    }

    @DeleteMapping("/memo")
    public String deleteMemo(@RequestParam int id) {
        System.out.println("deleteMemo: " + id);
        int result = memoService.delMemo(id);
        return result == 1 ? "성공" : "실패";
    }

}
