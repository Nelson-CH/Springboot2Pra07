package defaultNonScan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//創建層級錯誤的範例
@RestController
public class defaultNoScan {

    @GetMapping("/noscan")
    public String noscan() {
        return "noscan";
    }
}
