package exercise.service;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.repository.AuthorRepository;
import exercise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    // BEGIN
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookMapper bookMapper;

    public List<BookDTO> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(elem -> bookMapper.map(elem))
                .toList();
    }

    public BookDTO findById(Long id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found"));
        return bookMapper.map(book);
    }

    public BookDTO create(BookCreateDTO dto) {
        var model = bookMapper.map(dto);

        var authorId = model.getAuthor().getId();
        var author = authorRepository.findById(authorId)
                        .orElseThrow(() -> new ResourceNotFoundException(""));

        model.setAuthor(author);

        bookRepository.save(model);
        return bookMapper.map(model);
    }

    public BookDTO update(BookUpdateDTO dto, Long id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found"));
        bookMapper.update(dto, book);
        bookRepository.save(book);

        return bookMapper.map(book);
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
    // END
}
