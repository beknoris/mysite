package kz.kaznitu.jobs.controllers;

import kz.kaznitu.jobs.models.Job;
import kz.kaznitu.jobs.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @RequestMapping(value = "/addjob",method = RequestMethod.POST)
    public String addPlayer(@RequestParam String description,
                            @RequestParam String company,
                            Model model) {
        Job job = new Job();
        job.setDescription(description);
        job.setCompany(company);
        jobRepository.save(job);

        return "redirect:/jobs";
    }

    @RequestMapping(value = "/jobs", method = RequestMethod.GET)
    public String playersList(Model model){
        Job job = new Job();
        model.addAttribute("job",job);
        return "jobs";
    }
}
