package fitnessclub.com.repository;

import fitnessclub.com.entity.ActivitiesType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivitiesTypeRepository extends JpaRepository<ActivitiesType, Long> {

}
