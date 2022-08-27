package dao

// AUTO-GENERATED Slick data model for table User
trait UserTable {

  self: Tables =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** Entity class storing rows of table User
    * @param userId
    *   Database column user_id SqlType(uuid), PrimaryKey
    * @param username
    *   Database column username SqlType(varchar), Length(255,true)
    * @param createdAt
    *   Database column created_at SqlType(timestamp)
    * @param updatedAt
    *   Database column updated_at SqlType(timestamp)
    */
  case class UserRow(userId: java.util.UUID, username: String, createdAt: java.time.Instant, updatedAt: java.time.Instant)

  /** GetResult implicit for fetching UserRow objects using plain SQL queries */
  implicit def GetResultUserRow(implicit e0: GR[java.util.UUID], e1: GR[String], e2: GR[java.time.Instant]): GR[UserRow] = GR { prs =>
    import prs._
    UserRow.tupled((<<[java.util.UUID], <<[String], <<[java.time.Instant], <<[java.time.Instant]))
  }

  /** Table description of table user. Objects of this class serve as prototypes for rows in queries. */
  class User(_tableTag: Tag) extends profile.api.Table[UserRow](_tableTag, "user") {
    def * = (userId, username, createdAt, updatedAt) <> (UserRow.tupled, UserRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(userId), Rep.Some(username), Rep.Some(createdAt), Rep.Some(updatedAt))).shaped.<>(
      { r => import r._; _1.map(_ => UserRow.tupled((_1.get, _2.get, _3.get, _4.get))) },
      (_: Any) => throw new Exception("Inserting into ? projection not supported.")
    )

    /** Database column user_id SqlType(uuid), PrimaryKey */
    val userId: Rep[java.util.UUID] = column[java.util.UUID]("user_id", O.PrimaryKey)

    /** Database column username SqlType(varchar), Length(255,true) */
    val username: Rep[String] = column[String]("username", O.Length(255, varying = true))

    /** Database column created_at SqlType(timestamp) */
    val createdAt: Rep[java.time.Instant] = column[java.time.Instant]("created_at")

    /** Database column updated_at SqlType(timestamp) */
    val updatedAt: Rep[java.time.Instant] = column[java.time.Instant]("updated_at")

    /** Uniqueness Index over (username) (database name user_username_key) */
    val index1 = index("user_username_key", username, unique = true)
  }

  /** Collection-like TableQuery object for table User */
  lazy val User = new TableQuery(tag => new User(tag))
}
