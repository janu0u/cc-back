package task.management.project.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Backlog {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String projectIdentifier;

  //OneToOne with project
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "project_id", nullable = false)
  @JsonIgnore
  private Project project;

  @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "backlog", orphanRemoval = true)
  private List<ProjectTask> projectTasks = new ArrayList<>();

  public Backlog() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getProjectIdentifier() {
    return projectIdentifier;
  }

  public void setProjectIdentifier(String projectIdentifier) {
    this.projectIdentifier = projectIdentifier;
  }

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }

  public List<ProjectTask> getProjectTasks() {
    return projectTasks;
  }

  public void setProjectTasks(List<ProjectTask> projectTasks) {
    this.projectTasks = projectTasks;
  }

  @Override
  public String toString() {
    return "Backlog{" +
        "id=" + id +
        ", projectIdentifier='" + projectIdentifier + '\'' +
        ", project=" + project +
        ", projectTasks=" + projectTasks +
        '}';
  }
}
