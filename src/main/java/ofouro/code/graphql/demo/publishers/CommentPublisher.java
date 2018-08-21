package ofouro.code.graphql.demo.publishers;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.observables.ConnectableObservable;
import lombok.extern.slf4j.Slf4j;
import ofouro.code.graphql.demo.model.Note;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CommentPublisher {

    private final Flowable<NoteUpdate> publisher;

    private ObservableEmitter<NoteUpdate> emitter;

    public CommentPublisher() {
        Observable<NoteUpdate> commentUpdateObservable = Observable.create(emitter -> {
            this.emitter = emitter;
        });

        ConnectableObservable<NoteUpdate> connectableObservable = commentUpdateObservable.share().publish();
        connectableObservable.connect();


        publisher = connectableObservable.toFlowable(BackpressureStrategy.BUFFER);
    }

    public void publish(final Note note) {
        emitter.onNext(new NoteUpdate(note.getNote(), note.getAuthor().getName(), note.getCreatedOn().toString()));
    }


    public Flowable<NoteUpdate> getPublisher() {
        return publisher;
    }

}
