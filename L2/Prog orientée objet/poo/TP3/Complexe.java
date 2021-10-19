
/**
 *  * Décrivez votre classe Complexe ici.
 *   *
 *    * @author (votre nom)
 *     * @version (un numéro de version ou une date)
 *      */
public class Complexe{

	  /** attibuts partie reele et partie imaginaire **/
	  private double re = 0 ;
	    private double im = 0 ;

	    /** constructeur de la classe complexe **/
	      public Complexe(double a,double b){
		          this.re=a;
			      this.im=b;
			        }
	      /** getters et setter **/
	        public double getRe(){
			    return this.re;
			      }
		  public double getIm(){
			      return this.im;
			        }

		    public void setRe(double a){
			        this.re=a;
				  }

		      public void setIm(double b){
			          this.im=b;
				    }

		        /*renvoie le module de ce complexe
			 *       * @return le module de ce complexe
			 *             */
		           public double module() {
				            return Math.sqrt(this.re*this.re + this.im*this.im);
					         }

			     /* renvoie de conjugue de ce complexe
			      *       * @return le conjugue de ce complexe
			      *             */
			        public Complexe conjugue() {
					         return new Complexe(this.re, -this.im);
						      }

				  /* renvoie le complexe résultat de l'addition de this et c
				   *       * @param c le complexe ajouté
				   *             * @return le complexe résultat de l'addition de this et ce
				   *                   */
				     public Complexe add(Complexe c) {
					              return new Complexe(this.re + c.re, this.im + c.im);
						           }

				       /* renvoie le complexe résultat de la multiplication de this et c
					*       * @param c le complexe multiplié
					*             * @return le complexe résultat de la multiplication de this et c
					*                   */
				          public Complexe mult(Complexe c) {
						           double ree = this.re * c.re - this.im * c.im;
							            double ima = this.re * c.im + this.im * c.re;
								             return new Complexe(ree,ima) ;
									          }

					    public String toString() {
						             return this.re+"i"+this.im;
							          }
					      public boolean equals(Object o){
						          if(!(o instanceof Complexe)){
								      return false;
							  }
							      else{
								          Complexe other = (Complexe) o;
									      return this.im==other.getIm()&&this.re==other.getRe();
							      }
							          }
					          public static void main(String[] args){
							        System.out.println(Complexe comp1 = new Complexe(4,-3));
								      System.out.println(Complexe comp2 = new Complexe(-9,7));
								            System.out.println(comp1.conjugue());
									          System.out.println(comp2.conjugue());
										        Complexe comp3=new Complexe(comp1.add(comp2).getRe(),comp1.add(comp2).getIm());
											      Complexe comp4= new Complexe(comp1.mult(comp2).getRe(),comp1.mult(comp2).getIm());
											            System.out.println(comp3.equals(comp4));

												        }

						   }

