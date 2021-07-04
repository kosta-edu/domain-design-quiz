package com.kosta.server.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("samples")
public class SampleController {

    @Autowired
    private SampleService service;

    @GetMapping
    public List<SampleDomain> getDomainList(){
        return service.getAllSample();
    }

    @GetMapping("/{id}")
    public SampleDomain getDomain(@PathVariable int id) {
        return service.getSampleById(id);
    }

    @PostMapping
    public SampleDomain postDomain(@RequestBody SampleDomain sampleDomain){
        return service.upsertSample(sampleDomain);
    }

    @PutMapping("/{id}")
    public SampleDomain putDomain(@PathVariable int id, @RequestBody SampleDomain sampleDomain){
        SampleDomain s = service.getSampleById(id);
        s.setName(sampleDomain.getName());
        s.setDate(sampleDomain.getDate());
        return service.upsertSample(s);
    }

    @DeleteMapping("/{id}")
    public void deleteDomain(@PathVariable int id){
        service.deleteSample(id);
    }

}
