package com.kosta.server.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SampleService {

    @Autowired
    private SampleRepository repository;


    public List<SampleDomain> getAllSample(){
        return repository.findAll();
    }

    public SampleDomain getSampleById(int id){
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public SampleDomain upsertSample(SampleDomain sampleDomain){
        return repository.save(sampleDomain);
    }

    public void deleteSample(int id){
        repository.deleteById(id);
    }

}
