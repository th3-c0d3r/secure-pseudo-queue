package io.github.th3c0d3r.pseudoqueue.repo;

import io.github.th3c0d3r.pseudoqueue.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepo extends JpaRepository<Message, Integer> {
}
