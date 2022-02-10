package tz.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tz.server.entity.Robject;
import tz.server.repository.RobjectRepository;

import java.util.List;
import java.util.UUID;

@Service
public class RobjectServiceImpl implements RobjectService {

    @Autowired
    private RobjectRepository robjectRepository;

    @Override
    public List<Robject> readAll() {
        return robjectRepository.findAll();
    }

    @Override
    public Robject findByObjectId(UUID objectId) {
        return robjectRepository.findByObjectId(objectId);
    }

    @Override
    public Robject save(Robject robject) {
        return robjectRepository.save(robject);
    }

}
