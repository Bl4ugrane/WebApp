package org.example.blog.repository;

import org.example.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;



public interface PostRepository extends JpaRepository<Post, Long> {

     boolean existsById(Long id);

     List<Post> findByTitle(String title);

}
