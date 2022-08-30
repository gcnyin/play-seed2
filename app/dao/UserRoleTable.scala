package dao

// AUTO-GENERATED Slick data model for table UserRole
trait UserRoleTable {

  self: Tables =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** Entity class storing rows of table UserRole
    * @param userId
    *   Database column user_id SqlType(uuid), PrimaryKey
    * @param roleId
    *   Database column role_id SqlType(uuid)
    * @param createdAt
    *   Database column created_at SqlType(timestamptz)
    * @param updatedAt
    *   Database column updated_at SqlType(timestamptz)
    */
  case class UserRoleRow(userId: java.util.UUID, roleId: java.util.UUID, createdAt: java.time.Instant, updatedAt: java.time.Instant)

  /** GetResult implicit for fetching UserRoleRow objects using plain SQL queries */
  implicit def GetResultUserRoleRow(implicit e0: GR[java.util.UUID], e1: GR[java.time.Instant]): GR[UserRoleRow] = GR { prs =>
    import prs._
    UserRoleRow.tupled((<<[java.util.UUID], <<[java.util.UUID], <<[java.time.Instant], <<[java.time.Instant]))
  }

  /** Table description of table user_role. Objects of this class serve as prototypes for rows in queries. */
  class UserRole(_tableTag: Tag) extends profile.api.Table[UserRoleRow](_tableTag, "user_role") {
    def * = (userId, roleId, createdAt, updatedAt) <> (UserRoleRow.tupled, UserRoleRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(userId), Rep.Some(roleId), Rep.Some(createdAt), Rep.Some(updatedAt))).shaped.<>(
      { r => import r._; _1.map(_ => UserRoleRow.tupled((_1.get, _2.get, _3.get, _4.get))) },
      (_: Any) => throw new Exception("Inserting into ? projection not supported.")
    )

    /** Database column user_id SqlType(uuid), PrimaryKey */
    val userId: Rep[java.util.UUID] = column[java.util.UUID]("user_id", O.PrimaryKey)

    /** Database column role_id SqlType(uuid) */
    val roleId: Rep[java.util.UUID] = column[java.util.UUID]("role_id")

    /** Database column created_at SqlType(timestamptz) */
    val createdAt: Rep[java.time.Instant] = column[java.time.Instant]("created_at")

    /** Database column updated_at SqlType(timestamptz) */
    val updatedAt: Rep[java.time.Instant] = column[java.time.Instant]("updated_at")
  }

  /** Collection-like TableQuery object for table UserRole */
  lazy val UserRole = new TableQuery(tag => new UserRole(tag))
}
