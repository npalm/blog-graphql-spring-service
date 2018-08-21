package ofouro.code.graphql.demo.service;

import ofouro.code.graphql.demo.model.Note;
import ofouro.code.graphql.demo.model.Person;
import ofouro.code.graphql.demo.publishers.CommentPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotesService {

    private NoteRepository noteRepository;

    private PersonRepository personRepository;

    private CommentPublisher notePublisher;

    public NotesService(NoteRepository noteRepository, PersonRepository personRepository, CommentPublisher notePublisher) {
        this.noteRepository = noteRepository;
        this.personRepository = personRepository;
        this.notePublisher = notePublisher;

    }

    public Note save(Note note) {
        List<Person> authors = personRepository.findByName(note.getAuthor().getName());

        if (authors.size() == 1) {
            note.setAuthor(authors.get(0));
        } else {
            Person author = personRepository.save(note.getAuthor());
            note.setAuthor(author);
        }

        Note savedNoed = noteRepository.save(note);
        notePublisher.publish(savedNoed);
        return savedNoed;

    }


    public Optional<Note> findById(Long id) {
        return this.noteRepository.findById(id);
    }

    public List<Note> findAll() {
        return noteRepository.findAll();
    }
}

