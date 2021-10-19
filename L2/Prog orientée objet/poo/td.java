public class Curriculum {
    private String name;
	private Map<Subject, Integer> subjects;

	public Curriculum(String name) {
		this.name = name;
		this.subjects = new HashMap<Subject, Integer>();
	}

    
    public void addSubject(Subject sub , int coef){
        this.subjects.put(sub, coef);
    }

    public boolean containSubject(Subject sub){
        return this.subjects.cointainsKey(sub);
    }

    public Integer removeSubject(Subject sub){
        if (containSubject(sub)) {
            this.subjects.remove(sub);    
        } else {
            throw new KeyNotThereException();
        }
    }
    
    public int getCoef(Subject sub){
        return this.subjects.get(sub);
    }
    
    public Set<Subject> getSubjects(){
        return this.keySet();
    }
}




public class Student{
    private Identity ident;
    private String nip;
    private Curriculum curriculum;
    private Map<Subject, ArrayList<Integer>> marks;
}
    public void addMark(Subect sub , int mark){
        this.marks.get(sub).add(mark);
    }

    public ArrayList<Float> getMarksOfSubject(Subject sub){
        return this.get(sub)
    }

    public setCurriculum(Curriculum curriculum){
        this.curriculum = curriculum;
        this.marks = new HashMap<Subject, List<Float>>();

        for (Subject subject : this.curriculum.allSubjects()) {
	        this.marks.put(subject, new ArrayList<Float>());
        }
        
        

    
    }
    this.setCurriculum(this.curriculum);
    
    fLoat res ;
    if(this.cointainsSubject(sub) && !this.get(sub).isEmpty()){
        for(Float mark : this.get(sub)){
            res+=mark;
        }
        res = res/this.get(sub).size();
    }
    return res ;
}