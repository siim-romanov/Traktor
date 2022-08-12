package eu.vonamor.traktor.web;

import eu.vonamor.traktor.dto.ExecutionRequest;
import eu.vonamor.traktor.dto.Template;
import eu.vonamor.traktor.dto.requests.TreeFolderDto;
import eu.vonamor.traktor.services.HttpService;
import eu.vonamor.traktor.services.StoredRequestsService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller("/api/v1/stored-requests")
public class RequestController {

    private final HttpService httpService;
    private final StoredRequestsService storedRequestsService;

    public RequestController(HttpService httpService,
                             StoredRequestsService storedRequestsService) {
        this.httpService = httpService;
        this.storedRequestsService = storedRequestsService;
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public Flux<List<TreeFolderDto>> getAll() {
        return storedRequestsService.getRequestsTree();
    }

    @Post(produces = MediaType.APPLICATION_JSON)
    public Mono<String> create(Template template) {
        return storedRequestsService.create(template);
    }

    @Put(uri = "/{id}", produces = MediaType.APPLICATION_JSON)
    public Mono<String> update(@PathVariable Integer id, @Body Template template) {
        return storedRequestsService.update(id, template);
    }

    @Post(uri = "/{id}/execute", produces = MediaType.APPLICATION_JSON)
    public Mono<String> execute(@PathVariable Integer id, @Body ExecutionRequest req) {
        return storedRequestsService.execute(id, req);
    }
}
