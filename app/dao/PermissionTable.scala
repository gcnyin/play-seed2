package dao

// AUTO-GENERATED Slick data model for table Permission
trait PermissionTable {

  self: Tables =>

  import profile.api._
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** Entity class storing rows of table Permission
    * @param permissionId
    *   Database column permission_id SqlType(uuid), PrimaryKey
    * @param name
    *   Database column name SqlType(varchar), Length(255,true)
    * @param createdAt
    *   Database column created_at SqlType(timestamptz)
    * @param updatedAt
    *   Database column updated_at SqlType(timestamptz)
    */
  case class PermissionRow(permissionId: java.util.UUID, name: String, createdAt: java.time.Instant, updatedAt: java.time.Instant)

  /** GetResult implicit for fetching PermissionRow objects using plain SQL queries */
  implicit
  def GetResultPermissionRow(implicit e0: GR[java.util.UUID], e1: GR[String], e2: GR[java.time.Instant]): GR[PermissionRow] = GR { prs =>
    import prs._
    PermissionRow.tupled((<<[java.util.UUID], <<[String], <<[java.time.Instant], <<[java.time.Instant]))
  }

  /** Table description of table permission. Objects of this class serve as prototypes for rows in queries. */
  class Permission(_tableTag: Tag) extends profile.api.Table[PermissionRow](_tableTag, "permission") {
    def * = (permissionId, name, createdAt, updatedAt) <> (PermissionRow.tupled, PermissionRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(permissionId), Rep.Some(name), Rep.Some(createdAt), Rep.Some(updatedAt))).shaped.<>(
      { r => import r._; _1.map(_ => PermissionRow.tupled((_1.get, _2.get, _3.get, _4.get))) },
      (_: Any) => throw new Exception("Inserting into ? projection not supported.")
    )

    /** Database column permission_id SqlType(uuid), PrimaryKey */
    val permissionId: Rep[java.util.UUID] = column[java.util.UUID]("permission_id", O.PrimaryKey)

    /** Database column name SqlType(varchar), Length(255,true) */
    val name: Rep[String] = column[String]("name", O.Length(255, varying = true))

    /** Database column created_at SqlType(timestamptz) */
    val createdAt: Rep[java.time.Instant] = column[java.time.Instant]("created_at")

    /** Database column updated_at SqlType(timestamptz) */
    val updatedAt: Rep[java.time.Instant] = column[java.time.Instant]("updated_at")

    /** Uniqueness Index over (name) (database name permission_name_key) */
    val index1 = index("permission_name_key", name, unique = true)
  }

  /** Collection-like TableQuery object for table Permission */
  lazy val Permission = new TableQuery(tag => new Permission(tag))
}
