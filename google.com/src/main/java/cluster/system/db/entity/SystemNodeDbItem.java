package cluster.system.db.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@EntityScan
@Table(name = "SYSTEM_NODES_DB")
public class SystemNodeDbItem {

    public SystemNodeDbItem() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nameOfNode;
    @Column(name = "Coefficient_Of_Reliability")
    private Float coefficientOfReliabilityOfNode;

    private Float totalTimeOfCalculation, realTimeOfCalculation;

    private Integer totalNumberOfTasks, realNumberOfTasks;

    public SystemNodeDbItem(String nameOfNode) {
        this.nameOfNode = nameOfNode;
    }

    public String getNameOfNode() {
        return nameOfNode;
    }

    public void setNameOfNode(String nameOfNode) {
        this.nameOfNode = nameOfNode;
    }

    public Float getCoefficientOfReliabilityOfNode() {
        return coefficientOfReliabilityOfNode;
    }

    public void setCoefficientOfReliabilityOfNode(Float coefficientOfReliabilityOfNode) {
        this.coefficientOfReliabilityOfNode = coefficientOfReliabilityOfNode;
    }

    public Float getTotalTimeOfCalculation() {
        return totalTimeOfCalculation;
    }

    public void setTotalTimeOfCalculation(Float totalTimeOfCalculation) {
        this.totalTimeOfCalculation = totalTimeOfCalculation;
    }

    public Float getRealTimeOfCalculation() {
        return realTimeOfCalculation;
    }

    public void setRealTimeOfCalculation(Float realTimeOfCalculation) {
        this.realTimeOfCalculation = realTimeOfCalculation;
    }

    public Integer getTotalNumberOfTasks() {
        return totalNumberOfTasks;
    }

    public void setTotalNumberOfTasks(Integer totalNumberOfTasks) {
        this.totalNumberOfTasks = totalNumberOfTasks;
    }

    public Integer getRealNumberOfTasks() {
        return realNumberOfTasks;
    }

    public void setRealNumberOfTasks(Integer realNumberOfTasks) {
        this.realNumberOfTasks = realNumberOfTasks;
    }
}
