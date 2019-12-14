**# GraphqlSpring**
**simple GraphQL server with Spring Boot <br/>**
<br/>

*Produit Entity*
```
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
@Entity
public class Produit implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;
    private String label;
    private double prix;
}
```
*JPA Entity and Repository*
```
@Repository
public interface ProduitRepository extends JpaRepository<Produit,Integer> {}
```
*Query*
```
@Component
public class Query implements GraphQLQueryResolver {
    @Autowired
    ProduitRepository produitRepository;

    public Produit getProduit(Integer id){
        return produitRepository.findById(id).get();
    }
    public List<Produit> getAll(){
        return produitRepository.findAll();
    }
}
```

*GraphQL Schema*
```
type Query{
    getProduit(code: Int!) : Produit
    getAll : [Produit]
}
type Produit{
   code : Int !
   label : String ,
   prix : Float ,
}
```
<img src="img/Capture d’écran 2019-12-15 à 00.39.49.png">