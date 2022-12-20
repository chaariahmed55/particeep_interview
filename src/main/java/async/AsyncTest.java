package async;

import io.vavr.collection.List;
import io.vavr.*;
import io.vavr.control.Option;
import io.vavr.concurrent.Future;
import java.util.concurrent.CompletableFuture;

/**
 * You should complete the function in this class
 */
class AsyncTest {

  private static List<Enterprise> enterprises = List.of(
      new Enterprise("ent_1", "Google", "ceo_2"),
      new Enterprise("ent_2", "Facebook", "ceo_1")
  );

  private static List<Ceo> ceos = List.of(
      new Ceo("ceo_1", "Mark"),
      new Ceo("ceo_2", "Sundar"),
      new Ceo("ceo_3", "Bill")
  );

  public static CompletableFuture<Option<Ceo>> getCeoById(String ceo_id) {
    CompletableFuture<Option<Ceo>> resultat;
    for (Ceo ceo : ceos) {
      if (ceo.id == ceo_id) {
        resultat = Future.of(() -> Option.of(ceo)).toCompletableFuture();
        return resultat;
      }
    }
    resultat = Future.of(() -> Option.of((Ceo) null)).toCompletableFuture();
    return resultat;
  }


  public static CompletableFuture<Option<Enterprise>> getEnterpriseByCeoId(String ceo_id) {
  CompletableFuture<Option<Enterprise>> resultat;
    for (Enterprise enterprise : enterprises) {
      if (enterprise.ceo_id == ceo_id) {
        resultat = Future.of(() -> Option.of(enterprise)).toCompletableFuture();
        return resultat;
      }
    }
    resultat = Future.of(() -> Option.of((Enterprise) null)).toCompletableFuture();
    return resultat;
  }


  public static CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> getCEOAndEnterprise(String ceo_id) {
   CompletableFuture<Option<Enterprise>> enterpriseFuture = getEnterpriseByCeoId(ceo_id);
    CompletableFuture<Option<Ceo>> ceoFuture = getCeoById(ceo_id);
    Option<Ceo> ceo;
    Option<Enterprise> enterprise;

    try {
      ceo = ceoFuture.get();
      enterprise = enterpriseFuture.get();
    } catch (Exception e) {
      return null;
    }
    CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> resultat = Future.of(() -> Tuple.of(ceo, enterprise))
        .toCompletableFuture();
    return resultat;
  }

}
