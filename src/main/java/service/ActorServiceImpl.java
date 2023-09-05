package service;

import dao.ActorDao;
import entity.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    public ActorServiceImpl(ActorDao actorDao) {
        this.actorDao = actorDao;
    }

    private ActorDao actorDao;
    @Override
    public List<Actor> findAll() {
        return actorDao.findAll();
    }

    @Override
    public Actor findById(int id) {
        Optional<Actor> actor = actorDao.findById(id);
        if (actor.isPresent()) {
            return actor.get();
        }
        return null;
    }

    @Override
    public Actor save(Actor actor) {
        return actorDao.save(actor);
    }

    @Override
    public Actor delete(int id) {
        Actor actor = findById(id);
        actorDao.delete(actor);
        return actor;
    }
}
