package hibernate.example.onetomany.mapping;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import java.util.List;


@Entity
@Table(name = "Questions")
public class Question {

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private int id;

  @Column(name = "QUESTION_NAME")
  private String qName;


  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "qid")
  @OrderColumn(name = "type")
  private List<Answer> answerList;


  public int getId () {

    return id;
  }


  public void setId (int id) {

    this.id = id;
  }


  public String getqName () {

    return qName;
  }


  public void setqName (String qName) {

    this.qName = qName;
  }


  public List<Answer> getAnswerList () {

    return answerList;
  }


  public void setAnswerList (List<Answer> answerList) {

    this.answerList = answerList;
  }
}
