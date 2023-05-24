package druginfo.service.read.service;

import druginfo.service.read.repository.DrugRepository;
import druginfo.service.read.repository.InteractionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class InteractionService {

    @Autowired
    private InteractionRepository interactionRepository;
}
