package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;

import java.util.List;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import exercise.exception.ResourceNotFoundException;

// BEGIN
@RestController
public class CommentsController {
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "/comments")
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> index() {
        return commentRepository.findAll();
    }

    @GetMapping(path = "/comments/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Comment show(@PathVariable long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment with id " + id + " not found"));
    }

    @PostMapping(path = "/comments")
    @ResponseStatus(HttpStatus.CREATED)
    public Comment create(@RequestBody Comment comm) {
        commentRepository.save(comm);

        return comm;
    }

    @PutMapping(path = "/comments/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Comment update(@RequestBody Comment comm, @PathVariable long id) {
        var commUpdate = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment with id " + id + " not found"));

        commUpdate.setPostId(comm.getPostId());
        commUpdate.setBody(comm.getBody());

        return commUpdate;
    }

    @DeleteMapping(path = "/comments/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable long id) {
        commentRepository.deleteById(id);
    }


}
// END
