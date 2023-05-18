package fooddeliveryexam.domain;

import fooddeliveryexam.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "alertLogs", path = "alertLogs")
public interface AlertLogRepository
    extends PagingAndSortingRepository<AlertLog, Long> {}
