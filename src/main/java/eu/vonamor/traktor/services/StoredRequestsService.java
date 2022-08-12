package eu.vonamor.traktor.services;

import eu.vonamor.traktor.dto.ExecutionRequest;
import eu.vonamor.traktor.dto.Template;
import eu.vonamor.traktor.dto.requests.TreeFolderDto;
import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@Singleton
public class StoredRequestsService {

    public Flux<Template> getAll() {
        var temp = new Template();
        temp.setUrl("https://showcase.api.linx.twenty57.net/UnixTime/fromunixtimestamp?unixtimestamp=1549892280");

        return Flux.just(temp);
    }

    public Mono<String> execute(Integer id, ExecutionRequest req) {
        return null;
    }

    public Mono<String> create(Template template) {
        return null;
    }

    public Mono<String> update(Integer id, Template template) {
        return null;
    }

    public Flux<List<TreeFolderDto>> getRequestsTree() {

       return Flux.just(Collections.emptyList());
    }
}
