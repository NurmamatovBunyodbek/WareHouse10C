package org.example.warehouse10c.controller;

import org.example.warehouse10c.dto.OutPutDto;
import org.example.warehouse10c.model.OutPut;
import org.example.warehouse10c.model.Result;
import org.example.warehouse10c.service.OutPutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/output")
public class OutPutController {

    @Autowired
    OutPutService outPutService;


    @GetMapping()
    public List<OutPut> getOutP() {
        List<OutPut> list = outPutService.getAllOutPut();
        return list;
    }

    @PostMapping()
    public Result add(@RequestBody OutPutDto outPutDto) {
        Result result = outPutService.createOutPut(outPutDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id, @RequestBody OutPutDto outPutDto) {
        Result result = outPutService.updateOutPut(id, outPutDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result del(@PathVariable Integer id) {
        Result result = outPutService.deleted(id);
        return result;
    }


}
