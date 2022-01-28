package tz.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tz.server.entity.Dogovor;
import tz.server.repository.DogovorRepository;

import java.util.List;

@Service
public class DogovorServiceImpl implements DogovorService {

    @Autowired
    private DogovorRepository dogovorRepository;

    @Override
    public List<Dogovor> readAll() {
        return dogovorRepository.findAll();
    }
}
