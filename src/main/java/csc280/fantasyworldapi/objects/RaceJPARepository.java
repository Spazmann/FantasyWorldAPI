/**
 * @author dmann
 * @createdOn 12/7/2023 at 9:27 PM
 * @projectName Fantasy World API
 * @packageName csc280.fantasyworldapi.objects;
 */
package csc280.fantasyworldapi.objects;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RaceJPARepository extends JpaRepository<Race, Integer> {
}
