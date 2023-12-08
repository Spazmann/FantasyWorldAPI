/**
 * @author dmann
 * @createdOn 12/7/2023 at 9:19 PM
 * @projectName Fantasy World API
 * @packageName csc280.fantasyworldapi.objects;
 */
package csc280.fantasyworldapi.objects;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassJPARepository extends JpaRepository<Class, Integer> {
}
