package sorting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class SortController {

    @Autowired
    private SortResultRepo repository;

    @RequestMapping("/sort")
    public String sort(@RequestParam(value = "sort", required = false) String str, Model model) {
        if (str != null && !str.isEmpty()) {
            int[] asIntArray = Arrays.stream(str.split(","))
                    .map(String::trim).mapToInt(Integer::parseInt).toArray();
            SortResult result = new SortResult(asIntArray);
            model.addAttribute("origin", result.getOriginArray());
            model.addAttribute("result", result.getResultArray());
            repository.save(result);
        }

        model.addAttribute("results", repository.findAll());

        return "sort";
    }

}
