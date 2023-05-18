package fooddeliveryexam.domain;

import fooddeliveryexam.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "dekeveries",
    path = "dekeveries"
)
public interface DekeveryRepository
    extends PagingAndSortingRepository<Dekevery, Long> {}
