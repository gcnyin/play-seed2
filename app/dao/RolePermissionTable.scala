package dao

// AUTO-GENERATED Slick data model for table RolePermission
trait RolePermissionTable {

  self: Tables =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** Entity class storing rows of table RolePermission
    * @param roleId
    *   Database column role_id SqlType(uuid), PrimaryKey
    * @param permissionId
    *   Database column permission_id SqlType(uuid)
    * @param createdAt
    *   Database column created_at SqlType(timestamptz)
    * @param updatedAt
    *   Database column updated_at SqlType(timestamptz)
    */
  case class RolePermissionRow(
      roleId: java.util.UUID,
      permissionId: java.util.UUID,
      createdAt: java.time.Instant,
      updatedAt: java.time.Instant
  )

  /** GetResult implicit for fetching RolePermissionRow objects using plain SQL queries */
  implicit def GetResultRolePermissionRow(implicit e0: GR[java.util.UUID], e1: GR[java.time.Instant]): GR[RolePermissionRow] = GR { prs =>
    import prs._
    RolePermissionRow.tupled((<<[java.util.UUID], <<[java.util.UUID], <<[java.time.Instant], <<[java.time.Instant]))
  }

  /** Table description of table role_permission. Objects of this class serve as prototypes for rows in queries. */
  class RolePermission(_tableTag: Tag) extends profile.api.Table[RolePermissionRow](_tableTag, "role_permission") {
    def * = (roleId, permissionId, createdAt, updatedAt) <> (RolePermissionRow.tupled, RolePermissionRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(roleId), Rep.Some(permissionId), Rep.Some(createdAt), Rep.Some(updatedAt))).shaped.<>(
      { r => import r._; _1.map(_ => RolePermissionRow.tupled((_1.get, _2.get, _3.get, _4.get))) },
      (_: Any) => throw new Exception("Inserting into ? projection not supported.")
    )

    /** Database column role_id SqlType(uuid), PrimaryKey */
    val roleId: Rep[java.util.UUID] = column[java.util.UUID]("role_id", O.PrimaryKey)

    /** Database column permission_id SqlType(uuid) */
    val permissionId: Rep[java.util.UUID] = column[java.util.UUID]("permission_id")

    /** Database column created_at SqlType(timestamptz) */
    val createdAt: Rep[java.time.Instant] = column[java.time.Instant]("created_at")

    /** Database column updated_at SqlType(timestamptz) */
    val updatedAt: Rep[java.time.Instant] = column[java.time.Instant]("updated_at")
  }

  /** Collection-like TableQuery object for table RolePermission */
  lazy val RolePermission = new TableQuery(tag => new RolePermission(tag))
}
