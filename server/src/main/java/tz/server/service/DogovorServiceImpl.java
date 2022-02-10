package tz.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tz.server.entity.Dogovor;
import tz.server.repository.DogovorRepository;

import java.util.List;
import java.util.UUID;

@Service
public class DogovorServiceImpl implements DogovorService {

    @Autowired
    private DogovorRepository dogovorRepository;

    @Override
    public List<Dogovor> readAll() {
        return dogovorRepository.findAll();
    }

    @Override
    public Dogovor findByDogovorId(UUID dogovorId) {
        return dogovorRepository.findByDogovorId(dogovorId);
    }

    @Override
    public Dogovor save(Dogovor dogovor) {
        return dogovorRepository.save(dogovor);
    }


}
