package syntax_kotlin

fun String.test() = this + "test"

// in java:
// public final class ExtensionsKt {
//   @NotNull
//   public static final String test(@NotNull String $this$test) {
//      Intrinsics.checkNotNullParameter($this$test, "$this$test");
//      return $this$test + "test";
//   }
//}

