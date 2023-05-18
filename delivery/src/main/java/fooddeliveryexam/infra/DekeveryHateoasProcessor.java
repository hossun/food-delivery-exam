package fooddeliveryexam.infra;

import fooddeliveryexam.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class DekeveryHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Dekevery>> {

    @Override
    public EntityModel<Dekevery> process(EntityModel<Dekevery> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/pic")
                .withRel("pic")
        );

        return model;
    }
}
