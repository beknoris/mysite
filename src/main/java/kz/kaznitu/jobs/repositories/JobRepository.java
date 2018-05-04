package kz.kaznitu.jobs.repositories;

import kz.kaznitu.jobs.models.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job,Long> {
}
