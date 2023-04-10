package hibernate.example.collection.mapping;


import java.util.List;


public class Question {

  private int id;

  private String qName;

  private List<String> answers;


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


  public List<String> getAnswers () {

    return answers;
  }


  public void setAnswers (List<String> answers) {

    this.answers = answers;
  }


  @Override
  public String toString () {

    return "Question{" +
        "id=" + id +
        ", qName='" + qName + '\'' +
        ", answers=" + answers +
        '}';
  }
}
