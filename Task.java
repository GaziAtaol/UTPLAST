package logic;

import jakarta.persistence.*;

public class Task {

    private Long id;
    private String taskName;
    private Priority priority;
    private String description;
    
    public enum Priority {
        NISKI("Low"),
        SREDNI("Mid"),
        WYSOKI("High"),
        KRYTYCZNY("Critical");
        
        private final String displayName;
        
        Priority(String displayName) {
            this.displayName = displayName;
        }
        
        public String getDisplayName() {
            return displayName;
        }
        
        @Override
        public String toString() {
            return displayName;
        }
    }

    public Task() {
        this.priority = Priority.SREDNI;
    }
    
    public Task(String taskName, Priority priority, String description) {
        this.taskName = taskName;
        this.priority = priority;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }
    
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    
    public Priority getPriority() {
        return priority;
    }
    
    public void setPriority(Priority priority) {
        this.priority = priority;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isValid() {
        return taskName != null && !taskName.trim().isEmpty();
    }
    
    @Override
    public String toString() {
        return "Task{" +
                "taskName='" + taskName + '\'' +
                ", priority=" + priority +
                ", description='" + description + '\'' +
                '}';
    }
}