package fooddeliveryexam.infra;

import fooddeliveryexam.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class AlertLogHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<AlertLog>> {

    @Override
    public EntityModel<AlertLog> process(EntityModel<AlertLog> model) {
        return model;
    }
}
