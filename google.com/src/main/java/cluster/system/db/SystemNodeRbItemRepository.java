package cluster.system.db;

import cluster.system.db.entity.SystemNodeDbItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SystemNodeRbItemRepository extends JpaRepository<SystemNodeDbItem, Integer> {

}