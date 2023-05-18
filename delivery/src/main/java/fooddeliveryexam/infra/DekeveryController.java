package fooddeliveryexam.infra;

import fooddeliveryexam.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value="/dekeveries")
@Transactional
public class DekeveryController {

    @Autowired
    DekeveryRepository dekeveryRepository;

    @RequestMapping(
        value = "dekeveries/{id}/pick",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Dekevery pick(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /dekevery/pick  called #####");
        Optional<Dekevery> optionalDekevery = dekeveryRepository.findById(id);

        optionalDekevery.orElseThrow(() -> new Exception("No Entity Found"));
        Dekevery dekevery = optionalDekevery.get();
        dekevery.pick();

        dekeveryRepository.save(dekevery);
        return dekevery;
    }
}
