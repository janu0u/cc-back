package task.management.project.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Project name is required")
  private String projectName;

  @NotBlank(message = "Project Identifier is required")
  @Size(min = 4, max = 5, message = "Please use 4 to 5 characters")
  @Column(updatable = false, unique = true)
  private String projectIdentifier;

  @NotBlank(message = "Project description is required")
  private String description;

  @JsonFormat(pattern = "yyyy-mm-dd")
  private Date startDate;

  @JsonFormat(pattern = "yyyy-mm-dd")
  private Date endDate;

  @JsonFormat(pattern = "yyyy-mm-dd")
  @Column(updatable = false)
  private Date createdAt;

  @JsonFormat(pattern = "yyyy-mm-dd")
  private Date updatedAt;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "project")
  @JsonIgnore
  private Backlog backlog;

  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnore
  private User user;

  private String projectLeader;

  public Project() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public String getProjectIdentifier() {
    return projectIdentifier;
  }

  public void setProjectIdentifier(String projectIdentifier) {
    this.projectIdentifier = projectIdentifier;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date start_date) {
    this.startDate = start_date;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date end_date) {
    this.endDate = end_date;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date created_At) {
    this.createdAt = created_At;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updated_At) {
    this.updatedAt = updated_At;
  }

  public Backlog getBacklog() {
    return backlog;
  }

  public void setBacklog(Backlog backlog) {
    this.backlog = backlog;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getProjectLeader() {
    return projectLeader;
  }

  public void setProjectLeader(String projectLeader) {
    this.projectLeader = projectLeader;
  }

  @PrePersist
  protected void onCreate() {
    this.createdAt = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
    this.updatedAt = new Date();
  }

  @Override
  public String toString() {
    return "Project{" +
        "id=" + id +
        ", projectName='" + projectName + '\'' +
        ", projectIdentifier='" + projectIdentifier + '\'' +
        ", description='" + description + '\'' +
        ", startDate=" + startDate +
        ", endDate=" + endDate +
        ", createdAt=" + createdAt +
        ", updatedAt=" + updatedAt +
        ", backlog=" + backlog +
        ", user=" + user +
        ", projectLeader='" + projectLeader + '\'' +
        '}';
  }
}
