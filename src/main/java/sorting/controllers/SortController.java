package sorting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sorting.dataobjects.SortResult;
import sorting.repos.SortResultRepo;

import java.util.Arrays;

@RestController
public class SortController {

    @Autowired
    private SortResultRepo resultRepo;

    @RequestMapping(value= "/sort", method = RequestMethod.POST)
    public SortResult sort(@RequestBody String toSort) {
        int[] numbers = Arrays.stream(toSort.split(","))
                .map(String::trim).mapToInt(Integer::parseInt).toArray();
        return resultRepo.save(new SortResult(numbers));
    }

    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public Iterable<SortResult> listAll() {
        return resultRepo.findAll();
    }

}
